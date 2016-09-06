/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.cdi.api.test.interceptortricks;

import com.sun.org.apache.xerces.internal.impl.XMLEntityManager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InterceptionProxyFactory;
import javax.enterprise.inject.spi.builder.AnnotatedTypeConfigurator;
import javax.enterprise.util.AnnotationLiteral;

/**
 * Just an example to play around with Interceptors on producer methods and custom beans:
 * Created by antoine on 06/09/2016.
 */
@ApplicationScoped
public class MyFunnyInterceptedProducer {


    @Produces
    @RequestScoped
    public XMLEntityManager createJpaEmAssumed(InterceptionProxyFactory<XMLEntityManager> pm) {
        XMLEntityManager em;

        AnnotatedTypeConfigurator<em> atc = pm.configure();

        atc.add(new AnnotationLiteral<Transactional>() {
        });


        return pm.createInterceptionProxy(em);

    }

}
