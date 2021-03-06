/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.websvc.manager.api;


import java.io.File;
import java.net.URL;
import org.netbeans.modules.websvc.jaxwsmodelapi.WSService;
import org.netbeans.modules.websvc.saas.spi.websvcmgr.WsdlServiceProxyDescriptor;

/**
 * Metadata descriptor that contains the information for a single web service.
 * This metadata is associated (one-to-one) with a proxy jar.
 * 
 * @author quynguyen
 */
public class WebServiceDescriptor extends WsdlServiceProxyDescriptor {

    public WebServiceDescriptor(String name, String packageName, int wsType, URL wsdl, File xmlDescriptor, WSService model) {
        super(name, packageName, wsType, wsdl, xmlDescriptor, model);
    }

    public WebServiceDescriptor() {
    }
}
