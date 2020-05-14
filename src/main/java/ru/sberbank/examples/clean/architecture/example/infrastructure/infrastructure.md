# Infrastructure Layer

### Contains interaction with infrastructure

Means technologies to communicate with external systems

#### More detailed

* Implementations for Application Layer **port.out** interfaces
* Entry points to application (Controllers, Schedulers, etc.) that call implementations of **port.in** interfaces

#### Package structure:

* jms - interaction by jms (**both ports**)
* mail - interaction with e-mails (**only port.out**)
* persistence - interaction with databases (**only port.out**)
* schedule - scheduling tasks (**only port.in**)
* web - controllers and web-service clients (**both ports**)

#### Scope
Can see classes from Core Layer (Application + Domain)