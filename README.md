# Supermarket-Management-System-OSGI


### Group Details

| Name          | Student ID    | Email         |
| ------------- | ------------- | ------------- |
| Ranaweera G.R.D | IT21052606  | it21052606@my.sliit.lk |
| Wickramanayake V.P.P  | IT21041402  | it21041402@my.sliit.lk  |
| Priyabandu H.K.S.N  | IT21073564  | it21073564@my.sliit.lk  |
| Content Cell  | Content Cell  | Content Cell  |

### Introduction

<p>
The Supermarket Management system has been developed using the OSGi framework, which follows a service-oriented architecture and employs the microkernel architectural pattern. By creating service bundles for each service in the system and utilizing the service registry, the system is highly modular and flexible.
</p>
<p>
The system includes four producer service bundles: Employee management, car park management, billing management, and stock management. These services are made available to four consumer service bundles: Employee manager, car park security officer, cashier, and stock handler. The store manager oversees employees, while the stock handler manages items and dispatches orders. The car park security officer is responsible for managing vehicles in the store's car park, and the cashier generates and displays bills.
</p>
<p>
The architecture of the system allows for easy extension and customization, as each service is implemented as an independent bundle. This approach provides scalability and adaptability to meet changing business requirements. By separating the system into small, independent services, changes can be made to one part of the system without affecting the rest.
</p>
