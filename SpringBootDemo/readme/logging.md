### how to use logging

1. you can use java util logging, Log4j2, Logback
2. by default logback is used for logging
3. `private static final Logger logger = LoggerFactory.getLogger(EmployeServiceImpl.class);` write this to get Logger  from slf4j package.
4. slf4j is implementation of LogBack.
5. another way to use it by using @Slf4j annotation on class and insteal of logger just use `log.info()`.

### enabling debug and trace using config file
1. `logging.level.root = warn` this will print only warning and error.
2. `logging.level.root = info` info, error, warn will be printed
3. `logging.level.root = error` only error will be printed
4. `logging.level.root = debug` debug,info,warn,error,fatal will be printed
5. `logging.level.root = trace` all of them will be printed

6. `logging.level.root` we are changing configuration for root now but u can just add one directory like `logging.level.com.learning.services=info`
