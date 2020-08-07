# Kotlin-MVVM-Clean-Architecture-Template (Koin)
A modularized MVVM with dependecy injection. Dependency Injection with Koin

**Modules**
  
**1 app**
         Contains app UI implementation, Activities,fragments and adapters
  
 **2 Viewmodels**
         This modules has all the viewmodels tha communicate with the use case. This can be merged with app module
      
 **3 UseCases/ Interactors**
        This is the module that hold the business logics and the use-case (deleteUser, getUsers)
  
  **4 datasource**
        This module is a data source, it provide data from api call and local database. It is consumed by the use-case
  
  **5 domain**
       This a java module that has the app use cases and the utility classes that are used in all the modules


**Using the following**

        1.Koin dependency injection

        2.Rxjava for Streams

        3.Retrofit

        5.Room 
