package framework.service;


import framework.model.User;

public class UserCreator {
    public static final  String TESTDATA_USER_INPUTDATA = "testdata.user.inputData";
    public static final  String TESTDATA_USER_SEARCHRESULTDATA = "testdata.user.searchResultData";
    public static final String TESTDATA_USER_NUMBEROFINSTANCES = "testdata.user.numberOfInstances";
    public static final  String TESTDATA_USER_WHATINSTANCESFORINPUTDATA = "testdata.user.whatInstancesForInputData";
    public static final  String TESTDATA_USER_OPERATIONSYSTEMINPUTDATA = "testdata.user.operationSystemInputData";
    public static final  String TESTDATA_USER_VIRTUALMACHINETYPEINPUTDATA = "testdata.user.virtualMachineTypeInputData";
    public static final  String TESTDATA_USER_INSTANCENODESERIESINPUTDATA = "testdata.user.instanceNodeSeriesInputData";
    public static final  String TESTDATA_USER_INSTANCENODENAMEINPUTDATA = "testdata.user.instanceNodeNameInputData";
    public static final  String TESTDATA_USER_NUMBEROFGPUSINPUTDATA = "testdata.user.numberOfGPUsInputData";
    public static final   String TESTDATA_USER_TYPEOFGPUSINPUTDATA = "testdata.user.typeOfGPUsInputData";
    public static final  String TESTDATA_USER_LOCALSSDINPUTDATA = "testdata.user.localSSDInputData";
    public static final   String TESTDATA_USER_DATACENTERLOCATIONINPUTDATA = "testdata.user.datacenterLocationInputData";
    public static final String TESTDATA_USER_COMMITTEDUSAGEINPUTDATA = "testdata.user.committedUsageInputData";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReader.getTestData(TESTDATA_USER_INPUTDATA),
                TestDataReader.getTestData(TESTDATA_USER_SEARCHRESULTDATA),
                        TestDataReader.getTestData(TESTDATA_USER_NUMBEROFINSTANCES),
                                TestDataReader.getTestData(TESTDATA_USER_WHATINSTANCESFORINPUTDATA),
                                        TestDataReader.getTestData(TESTDATA_USER_OPERATIONSYSTEMINPUTDATA),
                                                TestDataReader.getTestData(TESTDATA_USER_VIRTUALMACHINETYPEINPUTDATA),
                                                        TestDataReader.getTestData(TESTDATA_USER_INSTANCENODESERIESINPUTDATA),
                                                                TestDataReader.getTestData(TESTDATA_USER_INSTANCENODENAMEINPUTDATA),
                                                                        TestDataReader.getTestData(TESTDATA_USER_NUMBEROFGPUSINPUTDATA),
                                                                                TestDataReader.getTestData(TESTDATA_USER_TYPEOFGPUSINPUTDATA),
                                                                                        TestDataReader.getTestData(TESTDATA_USER_LOCALSSDINPUTDATA),
                                                                                                TestDataReader.getTestData(TESTDATA_USER_DATACENTERLOCATIONINPUTDATA),
                                                                                                        TestDataReader.getTestData(TESTDATA_USER_COMMITTEDUSAGEINPUTDATA));
    }
}
