# redis的crud，基于springboot
- 源代码 https://github.com/xuwujing/springBoot-study
- 对于redis的配置文件
  - 最大建立连接等待时间，如果超过此时间将接到异常。设为-1表示无限制 redis.maxWaitMillis=-1  
  - 是否在从池中取出连接前进行检验,如果检验失败,则从池中去除连接并尝试取出另一个 redis.testOnBorrow=true  
  - 在空闲时检查有效性, 默认false redis.testWhileIdle=true  
  - 每次释放连接的最大数目,默认3　redis.numTestsPerEvictionRun=3 
- 对于redisconfig的配置
  - 在JedisPoolConfig中配置好appclication.properties中注册的项目,返回JedisPoolConfig池
  - 在JedisConnectFactory中配置好JedisPoolConfig,如果有密码配置密码
  - 初始化redisTemplate,把JedisConnectFactory放入redisTemplate
  - 在redisUtil中注册redisTemplate
- 在pojo类中的tostring方法采用JSONOBJECT（fastjson）中的tostring方法，且方法实现序列化
- 在RedisUtil中配置set,get,del方法
  - redisTemplate.opsForValue().set(key,value); set方法
  - redisTemplate.opsForValue().get(key);get方法
  -  if (key.length == 1) {redisTemplate.delete(key[0]); } else{ redisTemplate.delete(CollectionUtils.arrayToList(key));} 删除方法
- 在userDaoImpl中,Object.toString()导入redis
- 在findById中配置String data = redisUtil.get(String.valueOf(id)).toString();User user = JSON.parseObject(data, User.class);返回string,通过fastjson把他转化为实体类
