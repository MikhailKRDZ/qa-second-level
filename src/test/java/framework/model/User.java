package framework.model;

import java.util.Objects;

public class User {

    private String  inputData;
    private String searchResultData;
    private String numberOfInstances;
    private String whatInstancesForInputData;
    private String operationSystemInputData;
    private String virtualMachineTypeInputData;
    private String instanceNodeSeriesInputData;
    private String instanceNodeNameInputData;
    private String numberOfGPUsInputData;
    private String typeOfGPUsInputData;
    private String localSSDInputData;
    private String datacenterLocationInputData;
    private String committedUsageInputData;

    public User(String inputData,
                String searchResultData,
                String numberOfInstances,
                String whatInstancesForInputData,
                String operationSystemInputData,
                String virtualMachineTypeInputData,
                String instanceNodeSeriesInputData,
                String instanceNodeNameInputData,
                String numberOfGPUsInputData,
                String typeOfGPUsInputData,
                String localSSDInputData,
                String datacenterLocationInputData,
                String committedUsageInputData
    ) {
        this.inputData = inputData;
        this.searchResultData = searchResultData;
        this.numberOfInstances = numberOfInstances;
        this.whatInstancesForInputData = whatInstancesForInputData;
        this.operationSystemInputData = operationSystemInputData;
        this.virtualMachineTypeInputData = virtualMachineTypeInputData;
        this.instanceNodeSeriesInputData = instanceNodeSeriesInputData;
        this.instanceNodeNameInputData = instanceNodeNameInputData;
        this.numberOfGPUsInputData = numberOfGPUsInputData;
        this.typeOfGPUsInputData = typeOfGPUsInputData;
        this.localSSDInputData = localSSDInputData;
        this.datacenterLocationInputData = datacenterLocationInputData;
        this.committedUsageInputData = committedUsageInputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public void setSearchResultData(String searchResultData) {
        this.searchResultData = searchResultData;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public void setWhatInstancesForInputData(String whatInstancesForInputData) {
        this.whatInstancesForInputData = whatInstancesForInputData;
    }

    public void setOperationSystemInputData(String operationSystemInputData) {
        this.operationSystemInputData = operationSystemInputData;
    }

    public void setVirtualMachineTypeInputData(String virtualMachineTypeInputData) {
        this.virtualMachineTypeInputData = virtualMachineTypeInputData;
    }

    public void setInstanceNodeSeriesInputData(String instanceNodeSeriesInputData) {
        this.instanceNodeSeriesInputData = instanceNodeSeriesInputData;
    }

    public void setInstanceNodeNameInputData(String instanceNodeNameInputData) {
        this.instanceNodeNameInputData = instanceNodeNameInputData;
    }

    public void setNumberOfGPUsInputData(String numberOfGPUsInputData) {
        this.numberOfGPUsInputData = numberOfGPUsInputData;
    }

    public void setTypeOfGPUsInputData(String typeOfGPUsInputData) {
        this.typeOfGPUsInputData = typeOfGPUsInputData;
    }

    public void setLocalSSDInputData(String localSSDInputData) {
        this.localSSDInputData = localSSDInputData;
    }

    public void setDatacenterLocationInputData(String datacenterLocationInputData) {
        this.datacenterLocationInputData = datacenterLocationInputData;
    }

    public void setCommittedUsageInputData(String committedUsageInputData) {
        this.committedUsageInputData = committedUsageInputData;
    }

    public String getOperationSystemInputData() {
        return operationSystemInputData;
    }

    public String getInputData() {
        return inputData;
    }

    public String getSearchResultData() {
        return searchResultData;
    }

    public String getNumberOfInstances() {
        return numberOfInstances;
    }

    public String getWhatInstancesForInputData() {
        return whatInstancesForInputData;
    }

    public String getVirtualMachineTypeInputData() {
        return virtualMachineTypeInputData;
    }

    public String getInstanceNodeSeriesInputData() {
        return instanceNodeSeriesInputData;
    }

    public String getInstanceNodeNameInputData() {
        return instanceNodeNameInputData;
    }

    public String getNumberOfGPUsInputData() {
        return numberOfGPUsInputData;
    }

    public String getTypeOfGPUsInputData() {
        return typeOfGPUsInputData;
    }

    public String getLocalSSDInputData() {
        return localSSDInputData;
    }

    public String getDatacenterLocationInputData() {
        return datacenterLocationInputData;
    }

    public String getCommittedUsageInputData() {
        return committedUsageInputData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(inputData, user.inputData) && Objects.equals(searchResultData, user.searchResultData)
                && Objects.equals(numberOfInstances, user.numberOfInstances)
                && Objects.equals(whatInstancesForInputData, user.whatInstancesForInputData)
                && Objects.equals(operationSystemInputData, user.operationSystemInputData)
                && Objects.equals(virtualMachineTypeInputData, user.virtualMachineTypeInputData)
                && Objects.equals(instanceNodeSeriesInputData, user.instanceNodeSeriesInputData)
                && Objects.equals(instanceNodeNameInputData, user.instanceNodeNameInputData)
                && Objects.equals(numberOfGPUsInputData, user.numberOfGPUsInputData)
                && Objects.equals(typeOfGPUsInputData, user.typeOfGPUsInputData)
                && Objects.equals(localSSDInputData, user.localSSDInputData)
                && Objects.equals(datacenterLocationInputData, user.datacenterLocationInputData)
                && Objects.equals(committedUsageInputData, user.committedUsageInputData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputData,
                searchResultData,
                numberOfInstances,
                whatInstancesForInputData,
                operationSystemInputData,
                virtualMachineTypeInputData,
                instanceNodeSeriesInputData,
                instanceNodeNameInputData,
                numberOfGPUsInputData,
                typeOfGPUsInputData,
                localSSDInputData,
                datacenterLocationInputData,
                committedUsageInputData);
    }

    @Override
    public String toString() {
        return "User{" +
                "inputData='" + inputData + '\'' +
                ", searchResultData='" + searchResultData + '\'' +
                ", numberOfInstances='" + numberOfInstances + '\'' +
                ", whatInstancesForInputData='" + whatInstancesForInputData + '\'' +
                ", operationSystemInputData='" + operationSystemInputData + '\'' +
                ", virtualMachineTypeInputData='" + virtualMachineTypeInputData + '\'' +
                ", instanceNodeSeriesInputData='" + instanceNodeSeriesInputData + '\'' +
                ", instanceNodeNameInputData='" + instanceNodeNameInputData + '\'' +
                ", numberOfGPUsInputData='" + numberOfGPUsInputData + '\'' +
                ", typeOfGPUsInputData='" + typeOfGPUsInputData + '\'' +
                ", localSSDInputData='" + localSSDInputData + '\'' +
                ", datacenterLocationInputData='" + datacenterLocationInputData + '\'' +
                ", committedUsageInputData='" + committedUsageInputData + '\'' +
                '}';
    }

}
