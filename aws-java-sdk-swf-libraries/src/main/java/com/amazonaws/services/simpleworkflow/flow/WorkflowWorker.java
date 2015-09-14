/*
 * Copyright 2012 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.simpleworkflow.flow;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import com.amazonaws.services.simpleworkflow.AmazonSimpleWorkflow;
import com.amazonaws.services.simpleworkflow.flow.pojo.POJOWorkflowDefinitionFactoryFactory;
import com.amazonaws.services.simpleworkflow.flow.worker.GenericWorkflowWorker;

public class WorkflowWorker implements WorkerBase {

    private final GenericWorkflowWorker genericWorker;

    private final POJOWorkflowDefinitionFactoryFactory factoryFactory = new POJOWorkflowDefinitionFactoryFactory();

    private final Collection<Class<?>> workflowImplementationTypes = new ArrayList<Class<?>>();

    public WorkflowWorker(AmazonSimpleWorkflow service, String domain, String taskListToPoll) {
        genericWorker = new GenericWorkflowWorker(service, domain, taskListToPoll);
        genericWorker.setWorkflowDefinitionFactoryFactory(factoryFactory);
    }

    public AmazonSimpleWorkflow getService() {
        return genericWorker.getService();
    }

    public String getDomain() {
        return genericWorker.getDomain();
    }

    public boolean isRegisterDomain() {
        return genericWorker.isRegisterDomain();
    }

    public void setRegisterDomain(boolean registerDomain) {
        genericWorker.setRegisterDomain(registerDomain);
    }

    public long getDomainRetentionPeriodInDays() {
        return genericWorker.getDomainRetentionPeriodInDays();
    }

    public void setDomainRetentionPeriodInDays(long domainRetentionPeriodInDays) {
        genericWorker.setDomainRetentionPeriodInDays(domainRetentionPeriodInDays);
    }

    public String getTaskListToPoll() {
        return genericWorker.getTaskListToPoll();
    }

    public double getMaximumPollRatePerSecond() {
        return genericWorker.getMaximumPollRatePerSecond();
    }

    public void setMaximumPollRatePerSecond(double maximumPollRatePerSecond) {
        genericWorker.setMaximumPollRatePerSecond(maximumPollRatePerSecond);
    }

    public int getMaximumPollRateIntervalMilliseconds() {
        return genericWorker.getMaximumPollRateIntervalMilliseconds();
    }

    public void setMaximumPollRateIntervalMilliseconds(int maximumPollRateIntervalMilliseconds) {
        genericWorker.setMaximumPollRateIntervalMilliseconds(maximumPollRateIntervalMilliseconds);
    }

    public UncaughtExceptionHandler getUncaughtExceptionHandler() {
        return genericWorker.getUncaughtExceptionHandler();
    }

    public void setUncaughtExceptionHandler(UncaughtExceptionHandler uncaughtExceptionHandler) {
        genericWorker.setUncaughtExceptionHandler(uncaughtExceptionHandler);
    }

    public String getIdentity() {
        return genericWorker.getIdentity();
    }

    public void setIdentity(String identity) {
        genericWorker.setIdentity(identity);
    }

    public long getPollBackoffInitialInterval() {
        return genericWorker.getPollBackoffInitialInterval();
    }

    public void setPollBackoffInitialInterval(long backoffInitialInterval) {
        genericWorker.setPollBackoffInitialInterval(backoffInitialInterval);
    }

    public long getPollBackoffMaximumInterval() {
        return genericWorker.getPollBackoffMaximumInterval();
    }

    public void setPollBackoffMaximumInterval(long backoffMaximumInterval) {
        genericWorker.setPollBackoffMaximumInterval(backoffMaximumInterval);
    }

    public boolean isDisableServiceShutdownOnStop() {
        return genericWorker.isDisableServiceShutdownOnStop();
    }

    public void setDisableServiceShutdownOnStop(boolean disableServiceShutdownOnStop) {
        genericWorker.setDisableServiceShutdownOnStop(disableServiceShutdownOnStop);
    }

    public double getPollBackoffCoefficient() {
        return genericWorker.getPollBackoffCoefficient();
    }

    public void setPollBackoffCoefficient(double backoffCoefficient) {
        genericWorker.setPollBackoffCoefficient(backoffCoefficient);
    }

    public int getPollThreadCount() {
        return genericWorker.getPollThreadCount();
    }

    public void setPollThreadCount(int threadCount) {
        genericWorker.setPollThreadCount(threadCount);
    }

    public void registerTypesToPoll() {
        genericWorker.registerTypesToPoll();
    }

    public void start() {
        genericWorker.start();
    }

    public void shutdown() {
        genericWorker.shutdown();
    }

    public void shutdownNow() {
        genericWorker.shutdownNow();
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return genericWorker.awaitTermination(timeout, unit);
    }

    public boolean isRunning() {
        return genericWorker.isRunning();
    }

    public void suspendPolling() {
        genericWorker.suspendPolling();
    }

    public void resumePolling() {
        genericWorker.resumePolling();
    }

    public void setWorkflowImplementationTypes(Collection<Class<?>> workflowImplementationTypes)
            throws InstantiationException, IllegalAccessException {
        for (Class<?> workflowImplementationType : workflowImplementationTypes) {
            addWorkflowImplementationType(workflowImplementationType);
        }
    }

    public Collection<Class<?>> getWorkflowImplementationTypes() {
        return workflowImplementationTypes;
    }

    public void addWorkflowImplementationType(Class<?> workflowImplementationType) throws InstantiationException, IllegalAccessException {
        factoryFactory.addWorkflowImplementationType(workflowImplementationType);
    }

    public void addWorkflowImplementationType(Class<?> workflowImplementationType, DataConverter converter) throws InstantiationException, IllegalAccessException {
        factoryFactory.addWorkflowImplementationType(workflowImplementationType, converter);
    }
    
    public String toString() {
        return this.getClass().getSimpleName() + "[genericWorker=" + genericWorker + ", wokflowImplementationTypes="
                + workflowImplementationTypes + "]";
    }

    public boolean shutdownAndAwaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return genericWorker.shutdownAndAwaitTermination(timeout, unit);
    }

    public DataConverter getDataConverter() {
        return factoryFactory.getDataConverter();
    }

    public void setDefaultConverter(DataConverter converter) {
        factoryFactory.setDataConverter(converter);
    }

    public void setDisableTypeRegistrationOnStart(boolean disableTypeRegistrationOnStart) {
        genericWorker.setDisableTypeRegistrationOnStart(disableTypeRegistrationOnStart);
    }

    public boolean isDisableTypeRegistrationOnStart() {
        return genericWorker.isDisableTypeRegistrationOnStart();
    }

}
