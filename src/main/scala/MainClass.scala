object MainClass {
  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.WARN)
    Logger.getLogger("akka").setLevel(Level.WARN)
    //SparkSession
    val spark = SparkSession
      .builder()
      .master("local[*]")
      .appName("Akshay POC2")
      .enableHiveSupport()
      .config("spark.sql.warehouse.dir", "/tmp")
      .config("hive.exec.dynamic.partition", "true")
      .config("hive.exec.dynamic.partition.mode", "nonstrict")
      .getOrCreate()

    //Hbase Connection code*******************

    val conf = HBaseConfiguration.create()
    conf.set("hbase.zookeeper.quorum", "dbmaster.southindia.cloudapp.azure.com") //IP address of my Cloudera virtual machine
    conf.set("hbase.zookeeper.property.clientPort", "2181")

    val connection = ConnectionFactory.createConnection(conf)
    val admin = connection.getAdmin
    // list the tables
    val listtables: Array[HTableDescriptor] =admin.listTables()
    listtables.foreach(println)
  }
}