package framework.service;


import framework.model.User;

public class UserCreator {
    public static final String TESTDATA_SEARCH_INPUT = "testdata.search.input";
    public static final String TESTDATA_SEARCH_RESULT = "testdata.search.result";
    public static final String TESTDATA_NUMBEROFINSTANCES = "testdata.numberOfInstances";
    public static final String TESTDATA_WHATINSTANCESFOR = "testdata.whatInstancesFor";
    public static final String TESTDATA_OPERATIONSYSTEM = "testdata.operationSystem";
    public static final String TESTDATA_VIRTUALMACHINETYPE = "testdata.virtualMachineType";
    public static final String TESTDATA_INSTANCENODESERIES = "testdata.instanceNodeSeries";
    public static final String TESTDATA_INSTANCENODENAME = "testdata.instanceNodeName";
    public static final String TESTDATA_NUMBEROFGPUS = "testdata.numberOfGPUs";
    public static final String TESTDATA_TYPEOFGPUS = "testdata.typeOfGPUs";
    public static final String TESTDATA_LOCALSSD = "testdata.localSSD";
    public static final String TESTDATA_DATACENTERLOCATION = "testdata.datacenterLocation";
    public static final String TESTDATA_COMMITTEDUSAGE = "testdata.committedUsage";

    public static User withCredentialsFromProperty() {
        User user = new User();
        user.setSearchInput(TestDataReader.getTestData(TESTDATA_SEARCH_INPUT));
        user.setSearchResult(TestDataReader.getTestData(TESTDATA_SEARCH_RESULT));
        user.setNumberOfInstances(TestDataReader.getTestData(TESTDATA_NUMBEROFINSTANCES));
        user.setWhatInstancesFor(TestDataReader.getTestData(TESTDATA_WHATINSTANCESFOR));
        user.setOperationSystem(TestDataReader.getTestData(TESTDATA_OPERATIONSYSTEM));
        user.setVirtualMachineType(TestDataReader.getTestData(TESTDATA_VIRTUALMACHINETYPE));
        user.setInstanceNodeSeries(TestDataReader.getTestData(TESTDATA_INSTANCENODESERIES));
        user.setInstanceNodeName(TestDataReader.getTestData(TESTDATA_INSTANCENODENAME));
        user.setNumberOfGPUs(TestDataReader.getTestData(TESTDATA_NUMBEROFGPUS));
        user.setTypeOfGPUs(TestDataReader.getTestData(TESTDATA_TYPEOFGPUS));
        user.setLocalSSD(TestDataReader.getTestData(TESTDATA_LOCALSSD));
        user.setDatacenterLocation(TestDataReader.getTestData(TESTDATA_DATACENTERLOCATION));
        user.setCommittedUsage(TestDataReader.getTestData(TESTDATA_COMMITTEDUSAGE));
        return user;
    }
}