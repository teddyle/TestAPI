# MoveInMedAPI

## Installation

You can find the downloadable .jar in this repository, in the [release section.](https://github.com/siero34/MoveInMedAPI/releases)


## DataBase

### Configuration

As the project has been locally developed, you may want to change the database configuration to connect it to your own database.
You have to change the "gestionnaire\src\main\resources\application.properties" file in order to do so.
Then change the proporties under the "## PostgreSQL" tag.

### Schema Generation

As it fully uses the Hibernate properties, once it is connected to your database, the schema should be auto-generated.
There is no need to import a schema.sql file.

## URIs
| URI                                            | Method | Code          | Result                                                                                                                                                                  | Expected Request Format                                                                                                                                                                                                                                                                                                     |
|------------------------------------------------|--------|---------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| /patients                                      | GET    | 200           | List of all patients                                                                                                                                                    | None                                                                                                                                                                                                                                                                                                                        |
| /patients                                      | POST   |  400  201 204 |  Create a new patient <br>201 if successful  <br>204 if Json format is incorrect <br>400 if specified "pro_id" field is not found                                                   | {     "nom": "Dalmau",     "prenom": "Mickael",     "pro_id": 3,     "date_de_naissance": "08-03-1995",     "liste_pros": [1,2,3],     "num_tel": "0788905648",     "email": "dalmau.mickael@gmail.com",     "adresse": {         "adresse": "14 rue Révolution",         "ville": "Sète",         "zipCode": 34200     } } |
| /patients/{id}                                 | GET    |  400 200      |  Patient with the specified id <br>200 if found <br>400 otherwise                                                                                                               |                                                                                                                                                                                                                                                                                                                             |
| /patients/{id}/pros                            | GET    | 200           | Get all the pros of the specified patient                                                                                                                               |                                                                                                                                                                                                                                                                                                                             |
| /patients/{id}                                 | DELETE |  400 204      |  Delete the patient of the specified id <br>204 if successful <br>400 otherwise                                                                                                 |                                                                                                                                                                                                                                                                                                                             |
| /patients/{id}                                 | PUT    |  400 200      |  Update the specified patient <br>400 if the specified patient is not found <br>200 otherwise                                                                                   | {     "nom": "Palmau",     "prenom": "Mickael",     "pro_id": 3,     "date_de_naissance": "08-03-1995",     "liste_pros": [1,2,3],     "num_tel": "0788905648",     "email": "dalmau.mickael@gmail.com",     "adresse": {         "adresse": "14 rue Révolution",         "ville": "Sète",         "zipCode": 34200     } } |
| /patients/search?nom=xxx&&prenom=xxx&&date=xxx | GET    |  200 400      |  Get all patients with the corresponding parameters  <br>400 if there is no parameter specified <br>200 if successful <br>Date format : dd-MM-yyyy <br>The research is case sensitive ! |                                                                                                                                                                                                                                                                                                                             |
| /pros                                          | GET    | 200           | List of all pros                                                                                                                                                        |                                                                                                                                                                                                                                                                                                                             |
| /pros                                          | POST   |  204 201      |  Create a new Pro <br>201 if successful <br> 204 if Json format is incorrect <br>Accepted domaine value : psy, generaliste, assistante, chirurgien, infirmier, kine                 | {     "nom": "Fernandez",     "prenom": "Sarah",     "domaine": "psy",     "numTel": "0610277389",     "email": "sfernandez.psy@gmail.com",     "adresse": {         "adresse":"568 Rue de la Roqueturière",         "ville": "Montpellier",         "zipCode": 34090     } }                                               |
| /pros/{id}                                     | GET    |  400 200      |  Get the pro with the specified id <br>200 if successful <br>400 otherwise                                                                                                      |                                                                                                                                                                                                                                                                                                                             |
| /pros/search?nom=xxx&&prenom=xxx&&domaine=xxx  | GET    |  400 200      |  Get all pros with the specified parameters<br> 400 if there is no parameters<br> 200 otherwise <br>  Accepted domaine value : psy, generaliste, assistante, chirurgien, infirmier, kine                                                                              |                                                                                                                                                                                                                                                                                                                             |
| /pros/{id}                                     | DELETE |  400 204 500     |  Delete the pro with the specified id <br>204 if successful<br> 500 if the pro has dependency <br> 400 otherwise                                                                                                   |                                                                                                                                                                                                                                                                                                                             |
| /pros/{id}/patients                            | GET    | 200           | Get all patients related to the specified pro                                                                                                                           |                                                                                                                                                                                                                                                                                                                             |
| /pros/{id}                                     | PUT    |  200 400      |  Update the specified pro <br>200 if successful<br> 400 otherwise                                                                                                               | {     "nom": "Duquenne",     "prenom": "Jean-Guilhem",     "domaine": "generaliste",     "numTel": "0467630714",     "email": "duquenne@free.fr",     "adresse": {         "adresse":"1444 Route de Mende",         "ville": "Montpellier",         "zipCode": 34090     } }                                                |

## BE AWARE

Most of research are case sensitive, so be careful !<br>

No verification are made for cellphone numbers and email address, since they are simple Strings to make things easier.<br>

As patients have a foreign key of a pro, you may first create a pro before creating a patient.<br>

Deleting on cascade is not supported, if you delete a pro, and its foreign key is contained in a patient, you cannot delete it.<br>

A new address object is created everytime you create a patient/pro.<br>

Date format is : dd-MM-yyyy <br>

Domain value : generaliste, psy, kine, assistante, chirurgien, infirmier
