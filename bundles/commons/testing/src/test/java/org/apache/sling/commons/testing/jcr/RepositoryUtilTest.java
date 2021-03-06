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
package org.apache.sling.commons.testing.jcr;

import static org.junit.Assert.assertNotNull;

import javax.jcr.Session;

/**
 * This is a simple test for the repository util. We start
 * the repository, try to login as admin and anonymous and
 * then stop the repository.
 */
public class RepositoryUtilTest {

    @org.junit.Test public void testRepository() throws Exception {
        // start the repository
        RepositoryUtil.startRepository();

        // get admin session
        final Session adminSession = RepositoryUtil.getRepository().loginAdministrative(null);
        assertNotNull(adminSession);
        adminSession.logout();

        // get anonymous session
        final Session anonSession = RepositoryUtil.getRepository().login();
        assertNotNull(anonSession);
        anonSession.logout();

        // stop the repository
        RepositoryUtil.stopRepository();
    }
}
