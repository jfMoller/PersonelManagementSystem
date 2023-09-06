package org.example.ppab;

import org.example.ppab.utilities.AppMenu;
import org.example.ppab.utilities.PersonnelUtility;

public class Main {
    public static void main(String[] args) {
        PersonnelUtility.generateDefaultPersonnel();
        AppMenu.run();
    }
}
