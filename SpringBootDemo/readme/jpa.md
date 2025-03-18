### what is jpa 
1. jpa is not a framework it is a specification provided by java in order to manage relational data by using oops principles.

2. this needs implementation and hibernate is the implementation JPA

### why cant we use hibernate directly?
1. In case u have to migrate away from hibernate then u will need to lots of changes in ur application.

2. Jpa is kind of abstraction layer on top of ur hibernate.

3. it is standardized api which works with different kind of providers like hibernate.

### difference between spring data jpa and Jpa
1. spring data jpa is framework provided by spring in order to do ur database connections.

2. spring data JPA api is kind of abstraction on top of ur JPA which will provide u lot of interfaces.

### JPA Architecture and lifecycle of entity
1. when u create an entity it is managed by entity manager.

2. `EntityManager` is an interface in java which is responsible for managing entities. `EntityManager em = entityManagerFactory.createEntityManager(); em.persist(book);`

3. `EntityManagerFactory` is responsible for creating `EntityManager`.

4. and entity manager factory is managed by Persistance.

5. entity manager interacts with persistance context. think of `PersistanceContext` as a cache where entities will be stored here and entity manager is interacting with persistance context to get those entities.

6. `EntityManager` cannot directly interact with Database it will need some kind of provider. so all database related transaction will happen through Entity Transaction.

### Lifecycle of entity

1. there are 4 states in lifecycle of entity which are Removed, Transient, Managed, Detached.

2. when u create new entity in application it will be inside the **transient** state which is not yet managed by ur entity manager.

3. when u call `persist()` it will be now managed entity which is managed by `EntityManager` which is nothing but **managed** state.

4. whenever ur bean is in managed state it will be associated with Persistance context that means this new bean will added inside ur persistance context.

5. Now whenever ur entity is in managed state it will be automatically synchronized with database. so whatever transactions u do it will be reflected in ur database.

6. Whenever ur `detach()` those entities that were in persistance context will now longer managed by ur entity manager and persistance context and will be in **detached** state. u can move back to managed state by using `merge()` operation.

7. once u do `remove()` operation entities will be moved from managed to **removed** state.

### Diff betn CrudRepository, JpaRepository and PagingSortingRepository

1. `CrudRepository` provides very basic operation with database like crud operations, and this repository is very lightweight suitable for ur simple operations.

2. `PagingAndSortingRepository` this repo will give u features of paging and sorting this repo will extend crud repository.

3. `JpaRepository` this extends `PagingAndSortingRepository` which will have all functions of both above repos. and this repo also allows us to create custom query methods and batch operations.

### Update in spring 3.0 for repos

1. in old version when u were doing `findAll()` operation u were getting `Iterable<Employe>` which we then have to convert it to `List<Employe>`.

2. Because of such issue new version has given us new Repo `ListCrudRepository` and `ListPagingAndSortingRepository`.

3. In new version `PagingAndSortingRepository` is not extending `CrudRepository`  they are both extended by new `ListPagingAndSortingRepository` and `ListCrudRepository` respectively and our `JpaRepository` extends both.


### Query methods
1. in jpa u have method `findById(0)` to get data by its id but u wont have `findByName() or findBySalary()` so in that case u just need to create function `public List<Employe> findByName(String name);` u have to just follow naming convention starting with `findByDataMemberName` and spring data jpa will create automatically new query.

2. lets say u also want to find by name and salary then
`public Employe findByNameAndSalary(String name,int salary);`. and this also supports sorting `public List<Employe> findBySalaryOrderByNameAsc(String name,double salary);` by this it will sorted by name in ascending order.

### Query annotation

1. is used to create custom queries 