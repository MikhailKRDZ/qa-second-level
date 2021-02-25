package framework.model;

import java.util.Objects;

public class User {

    private String searchInput;
    private String searchResult;
    private String numberOfInstances;
    private String whatInstancesFor;
    private String operationSystem;
    private String virtualMachineType;
    private String instanceNodeSeries;
    private String instanceNodeName;
    private String numberOfGPUs;
    private String typeOfGPUs;
    private String localSSD;
    private String datacenterLocation;
    private String committedUsage;

    public User() {
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }

    public void setSearchResult(String searchResult) {
        this.searchResult = searchResult;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public void setWhatInstancesFor(String whatInstancesFor) {
        this.whatInstancesFor = whatInstancesFor;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public void setVirtualMachineType(String virtualMachineType) {
        this.virtualMachineType = virtualMachineType;
    }

    public void setInstanceNodeSeries(String instanceNodeSeries) {
        this.instanceNodeSeries = instanceNodeSeries;
    }

    public void setInstanceNodeName(String instanceNodeName) {
        this.instanceNodeName = instanceNodeName;
    }

    public void setNumberOfGPUs(String numberOfGPUs) {
        this.numberOfGPUs = numberOfGPUs;
    }

    public void setTypeOfGPUs(String typeOfGPUs) {
        this.typeOfGPUs = typeOfGPUs;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public void setCommittedUsage(String committedUsage) {
        this.committedUsage = committedUsage;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public String getSearchResult() {
        return searchResult;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getWhatInstancesFor() {
        return whatInstancesFor;
    }

    public String getVirtualMachineType() {
        return virtualMachineType;
    }

    public String getInstanceNodeSeries() {
        return instanceNodeSeries;
    }

    public String getInstanceNodeName() {
        return instanceNodeName;
    }

    public String getNumberOfGPUs() {
        return numberOfGPUs;
    }

    public String getTypeOfGPUs() {
        return typeOfGPUs;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommittedUsage() {
        return committedUsage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(searchInput, user.searchInput) && Objects.equals(searchResult, user.searchResult)
                && Objects.equals(numberOfInstances, user.numberOfInstances)
                && Objects.equals(whatInstancesFor, user.whatInstancesFor)
                && Objects.equals(operationSystem, user.operationSystem)
                && Objects.equals(virtualMachineType, user.virtualMachineType)
                && Objects.equals(instanceNodeSeries, user.instanceNodeSeries)
                && Objects.equals(instanceNodeName, user.instanceNodeName)
                && Objects.equals(numberOfGPUs, user.numberOfGPUs)
                && Objects.equals(typeOfGPUs, user.typeOfGPUs)
                && Objects.equals(localSSD, user.localSSD)
                && Objects.equals(datacenterLocation, user.datacenterLocation)
                && Objects.equals(committedUsage, user.committedUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(searchInput,
                searchResult,
                numberOfInstances,
                whatInstancesFor,
                operationSystem,
                virtualMachineType,
                instanceNodeSeries,
                instanceNodeName,
                numberOfGPUs,
                typeOfGPUs,
                localSSD,
                datacenterLocation,
                committedUsage);
    }

    @Override
    public String toString() {
        return "User{" +
                "inputData='" + searchInput + '\'' +
                ", searchResultData='" + searchResult + '\'' +
                ", numberOfInstances='" + numberOfInstances + '\'' +
                ", whatInstancesForInputData='" + whatInstancesFor + '\'' +
                ", operationSystemInputData='" + operationSystem + '\'' +
                ", virtualMachineTypeInputData='" + virtualMachineType + '\'' +
                ", instanceNodeSeriesInputData='" + instanceNodeSeries + '\'' +
                ", instanceNodeNameInputData='" + instanceNodeName + '\'' +
                ", numberOfGPUsInputData='" + numberOfGPUs + '\'' +
                ", typeOfGPUsInputData='" + typeOfGPUs + '\'' +
                ", localSSDInputData='" + localSSD + '\'' +
                ", datacenterLocationInputData='" + datacenterLocation + '\'' +
                ", committedUsageInputData='" + committedUsage + '\'' +
                '}';
    }

}
