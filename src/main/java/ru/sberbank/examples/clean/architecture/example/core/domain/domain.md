# Domain Layer

### Contains business rules

Means rules (maybe laws) of this application, examples:
* Child doctor can't accept adults
* Female doctor can't accept male
* Doctors can't accept patients on busy dates
* Patients with age higher than 18 are adults 

#### Package structure:

* entity - entities with creation and(or) interaction logic
* exception - possible exceptions
* service - services when entities can't interact directly

#### Scope
Can't see other layers