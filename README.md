# poi-google-export-testcase

A simple test case, demostrating a problem accessing data validations from Apache POI (4.1.2) from an XLSX spreadsheet, after exporting from Google Sheets.

Includes 3 cases:

* The original Excel file, where the validations can be accessed (**PASS**)
* The spreadsheet after being uploaded to Google Drive, converted to Google Sheets and then exported, and validations cannot be found (**FAIL**)
* The same exported spreadsheet opened and resaved in LibreOffice, where the validations _"appear"_ to have been repaired (**PASS**)

To run, with Maven 3 installed:

    mvn test

## Conclusion

The case that fails misses the _count_ attribute on the dataValidations element for the sheet1.xml, but which can be found for the successful cases :

    <dataValidations count="1">
        <dataValidation type="list" showInputMessage="1" showErrorMessage="1" sqref="C4">
            <formula1>validations</formula1>
        </dataValidation>
    </dataValidations>
    
i.e. see https://github.com/stuzart/poi-google-export-testcase/blob/master/src/test/resources/exported-unpacked/xl/worksheets/sheet1.xml#L1003

Without this attribute, the validation against the schema is still valid suggesting this attribute is optional.
 
Manually adding this attribute, and repackaging into the .xlsx file, and the dataValidations can be found by POI. This is confirmed by the test cases _testManuallyRepaired_. 

So it would seem that POI relies on this attribute being present to find the validations
