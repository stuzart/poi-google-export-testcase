# poi-google-export-testcase

A simple test case, demostrating a problem accessing data validations from Apache POI (4.1.2) from an XLSX spreadsheet, after exporting from Google Sheets.

Includes 3 cases:

* The original Excel file, where the validations can be accessed (**PASS**)
* The spreadsheet after being uploaded to Google Drive, converted to Google Sheets and then exported, and validations cannot be found (**FAIL**)
* The same exported spreadsheet opened and resaved in LibreOffice, where the validations _"appear"_ to have been repaired (**PASS**)
