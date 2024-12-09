package chatbotDSA;

import java.util.Scanner;

public class Program {
    private static Scanner scanner = new Scanner(System.in);
    
    private enum ServiceCategory {
        UNSELECTED, ID_SERVICES, TAX_SERVICES, PERMIT_SERVICES
    }
    
    private enum IDServiceType {
        UNSELECTED, RENEWAL, REPLACEMENT, FIRST_TIME
    }
    
    private enum TaxServiceType {
        UNSELECTED, FILING, PAYMENT_PLAN, REFUND_STATUS
    }
    
    private enum PermitServiceType {
        UNSELECTED, BUILDING_PERMIT, BUSINESS_LICENSE, EVENT_PERMIT
    }

    private static ServiceCategory currentCategory = ServiceCategory.UNSELECTED;
    private static IDServiceType currentIDService = IDServiceType.UNSELECTED;
    private static TaxServiceType currentTaxService = TaxServiceType.UNSELECTED;
    private static PermitServiceType currentPermitService = PermitServiceType.UNSELECTED;

    public static void main(String[] args) {
        boolean continueProgram = true;
        
        while (continueProgram) {
            resetCategories();
            
            welcomeUser();
            navigateUserInquiry();
            
            continueProgram = askToContinue();
        }
        
        farewell();
    }

    private static void resetCategories() {
        currentCategory = ServiceCategory.UNSELECTED;
        currentIDService = IDServiceType.UNSELECTED;
        currentTaxService = TaxServiceType.UNSELECTED;
        currentPermitService = PermitServiceType.UNSELECTED;
    }

    private static boolean askToContinue() {
        while (true) {
            System.out.println("\nWhat would you like to do next?");
            System.out.println("1. Return to Main Menu");
            System.out.println("2. Exit Program");
            System.out.print("Enter your choice: ");

            int choice = getUserChoice(2);

            switch (choice) {
                case 1:
                    return true;
                case 2:
                    return false;
            }
        }
    }

    private static void welcomeUser() {
        System.out.println("Welcome to the Comprehensive Government Services Assistant!");
        System.out.println("I'll help you navigate through various government services.");
    }

    private static void navigateUserInquiry() {
        determineServiceCategory();
        
        switch (currentCategory) {
            case ID_SERVICES:
                handleIDServices();
                break;
            case TAX_SERVICES:
                handleTaxServices();
                break;
            case PERMIT_SERVICES:
                handlePermitServices();
                break;
            default:
                System.out.println("Unable to process your request. Please try again.");
        }
    }
    
    private static void handleIDServices() {
        determineIDServiceType();
        
        switch (currentIDService) {
            case RENEWAL:
                processIDRenewal();
                break;
            case REPLACEMENT:
                processIDReplacement();
                break;
            case FIRST_TIME:
                processFirstTimeID();
                break;
            default:
                System.out.println("Unable to process ID service request.");
        }
    }
    
    private static void processIDRenewal() {
        System.out.println("\nID Renewal Process:");
        System.out.println("Please check the following requirements:");
        
        System.out.println("Are you within 6 months of your current ID expiration?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int expirationChoice = getUserChoice(2);
        
        if (expirationChoice == 2) {
            System.out.println("You cannot renew your ID until within 6 months of expiration.");
            return;
        }

        System.out.println("\nDo you have all required documents?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int documentsChoice = getUserChoice(2);
        
        if (documentsChoice == 2) {
            System.out.println("\nRequired Documents for ID Renewal:");
            System.out.println("- Current government-issued ID");
            System.out.println("- Proof of residence");
            System.out.println("- Social Security Number");
            return;
        }

        System.out.println("\nRenewal Complete! Please proceed to your local government office.");
    }

    private static void processIDReplacement() {
        System.out.println("\nID Replacement Process:");
        System.out.println("Reason for replacement?");
        System.out.println("1. Lost ID");
        System.out.println("2. Stolen ID");
        System.out.println("3. Damaged ID");
        int replacementReason = getUserChoice(3);

        System.out.println("\nAdditional Documentation Required:");
        switch (replacementReason) {
            case 1:
                System.out.println("- Police report recommended");
                break;
            case 2:
                System.out.println("- Police report mandatory");
                break;
            case 3:
                System.out.println("- Bring current damaged ID");
                break;
        }

        System.out.println("\nPlease gather required documents and visit local office.");
    }

    private static void processFirstTimeID() {
        System.out.println("\nFirst-Time ID Application:");
        System.out.println("Please confirm you have:");
        System.out.println("1. Proof of citizenship");
        System.out.println("2. Birth certificate");
        System.out.println("3. Social Security Number");
        System.out.println("4. Proof of residence");
        
        System.out.println("\nAre you 18 years or older?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int ageChoice = getUserChoice(2);

        if (ageChoice == 2) {
            System.out.println("Additional guardian consent may be required.");
        }

        System.out.println("\nPlease proceed to local government office with documents.");
    }


    private static void determineIDServiceType() {
        while (currentIDService == IDServiceType.UNSELECTED) {
            System.out.println("\nWhat specific ID service do you need?");
            System.out.println("1. ID Renewal");
            System.out.println("2. ID Replacement");
            System.out.println("3. First-Time ID");
            System.out.print("Enter the number of your ID service: ");

            int choice = getUserChoice(3);

            switch (choice) {
                case 1:
                    currentIDService = IDServiceType.RENEWAL;
                    break;
                case 2:
                    currentIDService = IDServiceType.REPLACEMENT;
                    break;
                case 3:
                    currentIDService = IDServiceType.FIRST_TIME;
                    break;
            }
        }
    }

    private static void determineServiceCategory() {
        while (currentCategory == ServiceCategory.UNSELECTED) {
            System.out.println("\nWhat type of service do you need help with?");
            System.out.println("1. ID Services");
            System.out.println("2. Tax Services");
            System.out.println("3. Permit Services");
            System.out.print("Enter the number of your service category: ");

            int choice = getUserChoice(3);

            switch (choice) {
                case 1:
                    currentCategory = ServiceCategory.ID_SERVICES;
                    break;
                case 2:
                    currentCategory = ServiceCategory.TAX_SERVICES;
                    break;
                case 3:
                    currentCategory = ServiceCategory.PERMIT_SERVICES;
                    break;
            }
        }
    }

    private static void handleTaxServices() {
        determineTaxServiceType();
        
        switch (currentTaxService) {
            case FILING:
                processTaxFiling();
                break;
            case PAYMENT_PLAN:
                processPaymentPlan();
                break;
            case REFUND_STATUS:
                checkRefundStatus();
                break;
            default:
                System.out.println("Unable to process tax service request.");
        }
    }

    private static void determineTaxServiceType() {
        while (currentTaxService == TaxServiceType.UNSELECTED) {
            System.out.println("\nWhat specific tax service do you need?");
            System.out.println("1. Tax Filing");
            System.out.println("2. Payment Plan");
            System.out.println("3. Refund Status");
            System.out.print("Enter the number of your tax service: ");

            int choice = getUserChoice(3);

            switch (choice) {
                case 1:
                    currentTaxService = TaxServiceType.FILING;
                    break;
                case 2:
                    currentTaxService = TaxServiceType.PAYMENT_PLAN;
                    break;
                case 3:
                    currentTaxService = TaxServiceType.REFUND_STATUS;
                    break;
            }
        }
    }

    private static void processTaxFiling() {
        System.out.println("\nTax Filing Process:");
        System.out.println("Select your filing status:");
        System.out.println("1. Individual");
        System.out.println("2. Business");
        System.out.println("3. Self-Employed");
        int filingStatus = getUserChoice(3);

        System.out.println("\nRequired Documents:");
        switch (filingStatus) {
            case 1:
                System.out.println("- W-2 Forms");
                System.out.println("- 1099 Forms (if applicable)");
                break;
            case 2:
                System.out.println("- Business Income Records");
                System.out.println("- Expense Receipts");
                System.out.println("- Previous Year's Tax Return");
                break;
            case 3:
                System.out.println("- Income Statements");
                System.out.println("- Expense Receipts");
                System.out.println("- 1099 Forms");
                break;
        }

        System.out.println("\nRecommended next steps:");
        System.out.println("- Gather all necessary documents");
        System.out.println("- Use official government tax filing website");
        System.out.println("- Consider consulting a tax professional");
    }

    private static void processPaymentPlan() {
        System.out.println("\nTax Payment Plan Options:");
        System.out.println("Do you owe taxes?");
        System.out.println("1. Yes, I owe taxes");
        System.out.println("2. No, I'm exploring preventive options");
        int oweTaxes = getUserChoice(2);

        if (oweTaxes == 1) {
            System.out.println("\nPayment Plan Options:");
            System.out.println("1. Short-term payment plan (120 days or less)");
            System.out.println("2. Long-term payment plan (longer than 120 days)");
            System.out.println("\nRequired Information:");
            System.out.println("- Total tax amount owed");
            System.out.println("- Ability to make monthly payments");
            System.out.println("- Current financial status");
        } else {
            System.out.println("\nPreventive Tax Planning Tips:");
            System.out.println("- Estimate annual tax liability");
            System.out.println("- Make quarterly estimated tax payments");
            System.out.println("- Consult with a tax advisor");
        }
    }

    private static void checkRefundStatus() {
        System.out.println("\nRefund Status Inquiry:");
        System.out.println("Select your refund type:");
        System.out.println("1. Individual Tax Refund");
        System.out.println("2. Business Tax Refund");
        int refundType = getUserChoice(2);

        System.out.println("\nRequired Information for Checking Refund:");
        if (refundType == 1) {
            System.out.println("- Social Security Number");
            System.out.println("- Exact refund amount");
            System.out.println("- Tax Year");
        } else {
            System.out.println("- Federal Employer Identification Number (FEIN)");
            System.out.println("- Tax Year");
            System.out.println("- Business Tax Identification");
        }

        System.out.println("\nNote: Official refund status can only be checked on government tax website.");
    }

    private static void handlePermitServices() {
        determinePermitServiceType();
        
        switch (currentPermitService) {
            case BUILDING_PERMIT:
                processBuildingPermit();
                break;
            case BUSINESS_LICENSE:
                processBusinessLicense();
                break;
            case EVENT_PERMIT:
                processEventPermit();
                break;
            default:
                System.out.println("Unable to process permit service request.");
        }
    }

    private static void determinePermitServiceType() {
        while (currentPermitService == PermitServiceType.UNSELECTED) {
            System.out.println("\nWhat specific permit service do you need?");
            System.out.println("1. Building Permit");
            System.out.println("2. Business License");
            System.out.println("3. Event Permit");
            System.out.print("Enter the number of your permit service: ");

            int choice = getUserChoice(3);

            switch (choice) {
                case 1:
                    currentPermitService = PermitServiceType.BUILDING_PERMIT;
                    break;
                case 2:
                    currentPermitService = PermitServiceType.BUSINESS_LICENSE;
                    break;
                case 3:
                    currentPermitService = PermitServiceType.EVENT_PERMIT;
                    break;
            }
        }
    }

    private static void processBuildingPermit() {
        System.out.println("\nBuilding Permit Application:");
        System.out.println("Select type of construction:");
        System.out.println("1. Residential");
        System.out.println("2. Commercial");
        System.out.println("3. Renovation");
        int constructionType = getUserChoice(3);

        System.out.println("\nRequired Documentation:");
        switch (constructionType) {
            case 1:
                System.out.println("- Property Deed");
                System.out.println("- Detailed Construction Plans");
                System.out.println("- Zoning Compliance Certificate");
                break;
            case 2:
                System.out.println("- Business Property Ownership Proof");
                System.out.println("- Architectural Blueprints");
                System.out.println("- Environmental Impact Assessment");
                break;
            case 3:
                System.out.println("- Current Property Ownership");
                System.out.println("- Renovation Detailed Plans");
                System.out.println("- Contractor Licenses");
                break;
        }

        System.out.println("\nNext Steps:");
        System.out.println("- Submit all required documentation");
        System.out.println("- Pay processing fees");
        System.out.println("- Await permit approval");
    }

    private static void processBusinessLicense() {
        System.out.println("\nBusiness License Application:");
        System.out.println("Select your business type:");
        System.out.println("1. Small Business");
        System.out.println("2. Corporation");
        System.out.println("3. Non-Profit");
        int businessType = getUserChoice(3);

        System.out.println("\nRequired Documentation:");
        switch (businessType) {
            case 1:
                System.out.println("- Business Registration");
                System.out.println("- Tax Identification Number");
                System.out.println("- Proof of Local Address");
                break;
            case 2:
                System.out.println("- Articles of Incorporation");
                System.out.println("- Corporate Tax ID");
                System.out.println("- Organizational Structure Documents");
                break;
            case 3:
                System.out.println("- Non-Profit Status Certificate");
                System.out.println("- Organizational Bylaws");
                System.out.println("- Tax Exemption Documentation");
                break;
        }

        System.out.println("\nApplication Process:");
        System.out.println("- Complete all required forms");
        System.out.println("- Submit documentation");
        System.out.println("- Pay licensing fees");
    }

    private static void processEventPermit() {
        System.out.println("\nEvent Permit Application:");
        System.out.println("Select event type:");
        System.out.println("1. Public Gathering");
        System.out.println("2. Private Event");
        System.out.println("3. Commercial Event");
        int eventType = getUserChoice(3);

        System.out.println("\nRequired Information:");
        switch (eventType) {
            case 1:
                System.out.println("- Expected Number of Attendees");
                System.out.println("- Event Location Details");
                System.out.println("- Safety and Security Plan");
                break;
            case 2:
                System.out.println("- Property Owner Permission");
                System.out.println("- Event Description");
                System.out.println("- Basic Safety Considerations");
                break;
            case 3:
                System.out.println("- Business Event License");
                System.out.println("- Detailed Event Logistics");
                System.out.println("- Insurance Documentation");
                break;
        }

        System.out.println("\nImportant Considerations:");
        System.out.println("- Apply well in advance of event date");
        System.out.println("- Be prepared for potential inspections");
        System.out.println("- Comply with all local regulations");
    }

    private static int getUserChoice(int maxChoice) {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice > 0 && choice <= maxChoice) {
                    return choice;
                }
                System.out.println("Please enter a valid number between 1 and " + maxChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void farewell() {
        System.out.println("\nThank you for using the Government Services Assistant.");
        System.out.println("Have a great day!");
    }
}