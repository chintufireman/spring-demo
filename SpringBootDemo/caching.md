### how to use
1. to use caching in spring boot u have to enable it in application.

2. use `@EnableCaching` on top of ur configuration class or on top of `@SpringBootApplication` main class.

3. suppose u have a function to get employee from database and lets consider there's one employee which needs to be fetched from database again and again. so u will have to call `getEmployee()` again and again for the same employe. 

4. so what u can do is u can cache that whole function by using `@Cacheable("employee")`empolyee is name of that cache. 

5. now if u debug u will notice that for the first time when u are fetching the data it will call the database but if u are fetching it for another time for the same id of employee it will not hit the database it will just stores its record in ram.

6. for all request it will cache the data so doesn't matter how many from new ids u get employee after first hit of new ids it won't hit db again for data.

### checking what is in our cache
1. You create a service class `CacheInspectionService` then u will use `CacheManager`
to get ur cache details, like from it.

2. you will create a user defined function and pass the name of cache u want to see like employee and then using `cacheManger.getCache(cacheName)` you will get all the details u want. about ur cache.

### types of cache
1. in memory- it is a cache which is created inside the memory of ur application. by default ur cache is stored in ur in-memory.

2. distributed- if u have multiple instances of ur applications in-memory cache wont work because it will get stacked.  because each node will have its own cache that will live the data inconsistency when trying to use cache.

3. that's when we need distributed cache, which is out of ur application. like redis now all nodes will be connected to this common distributed cache management and store.


### annotations used in cache
1. `CachePut("employee")` suppose u have data which u updated in ur database, now that old data was cached so when u try to get that cached it wont be updated. that's why we use cache put on updating function so that we can let spring boot know that update our cache as well.

2. the new updated data will be cached no issue but it wont override the old data as it doesn't know it is already present in ur cache memory. 

3. to avoid this u can add key in ur `@Cacheable(value="employee", key="#id")` and `@CachePut(value="employee",key = "#id")` so now same key will be updated, important u should try to debug without key and with key so u will understand its significance

4. `@CacheEvict(value="employee",key = "#id")` when u delete some resource from ur db that might be cached in ur application so to not this happen u delete the cached data as well from ur in-memory.