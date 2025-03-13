### @conditionalonproperty
1. this is used to create bean conditionally
2. lets say u have 2 db connections MySqlConnection and NoSqlConnection and you only need one.
3. lets say we have 2 components sharing same db. but 1 need Mysqlconnection and other need NoSqlConnection

4. you implement this by adding `@ConditionalOnProperty(prefix = "nosqlconnection", value ="enabled", havingValue = "create", matchIfMissing = false)` on top of bean which u want.

5. If in ur application.properties file u have added `nosqlconnection.enabled = create` then this will create the bean else if value is different then it wont.

6. Also remember when autowiring this bean u have to mention `@Autowired(required = false)` so that spring will know this bean might be injected or not if u dont add required = false then spring will throw error of Null values.

### 