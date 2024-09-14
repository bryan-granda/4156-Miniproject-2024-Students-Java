# How to test Project

## PMD commands
Must have PMD installed.
Please refer to the PMD website to receive instructions on how to install PMD.
[link](https://pmd.github.io/)

1. Once installed, Nagivate to the src folder within the /4156-Miniproject-2024-Students-Java/IndividualProject folder.

2. Run the following command:

### For Windows:
pmd.bat check -R rulesets/java/quickstart.xml -d ./

### For MacOS:
pmd check -R rulesets/java/quickstart.xml -d ./

Also, run following commands to run PMD with Maven
mvn pmd:check

mvn pmd:pmd

