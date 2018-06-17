# document of agv_master

# 用户登录：密码不可看，需要加密比较；

# --util
  --agv communication
  ----TCP/IP connect
  ----decode the agv message
  ----transit the data to business layer
  --database manager
  ----construct a cache what contains the traffic data, such as agv position and agv error state
  ----save to db file by another thread
  --agv monitor
  ----show agv status of agvs
  --agv traffic controller
  ----TODO