/*
 * Copyright 2014 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apiman.manager.api.rest.impl;

import io.apiman.manager.api.beans.system.SystemStatusBean;
import io.apiman.manager.api.config.Version;
import io.apiman.manager.api.core.IStorage;
import io.apiman.manager.api.rest.contract.ISystemResource;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Implementation of the System API.
 * 
 * @author eric.wittmann@redhat.com
 */
@ApplicationScoped
public class SystemResourceImpl implements ISystemResource {
    
    @Inject
    private IStorage storage;
    @Inject
    private Version version;
    
    /**
     * Constructor.
     */
    public SystemResourceImpl() {
    }

    /**
     * @see io.apiman.manager.api.rest.contract.ISystemResource#getStatus()
     */
    @Override
    public SystemStatusBean getStatus() {
        SystemStatusBean rval = new SystemStatusBean();
        rval.setUp(getStorage() != null);
        if (getVersion() != null) {
            rval.setVersion(getVersion().getVersionString());
        }
        return rval;
    }

    /**
     * @return the storage
     */
    public IStorage getStorage() {
        return storage;
    }

    /**
     * @param storage the storage to set
     */
    public void setStorage(IStorage storage) {
        this.storage = storage;
    }

    /**
     * @return the version
     */
    public Version getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(Version version) {
        this.version = version;
    }
}
