package com.electra.automation.utilities;

public class ADTFUtility {

    private boolean operationSelected = false;

    public boolean isOperationAvailable() {
        return !operationSelected;
    }

    public void markOperationSelected() {
        operationSelected = true;
    }

    public void resetOperation() {
        operationSelected = false;
    }
}
