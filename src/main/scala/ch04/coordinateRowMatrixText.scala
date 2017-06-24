package ch04
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed._
/**
  * Created by MKD on 2017/6/24.
  */
object coordinateRowMatrixText {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    .setMaster("local")
    .setAppName("coordinateRowMatrixText")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d://work//Spark MLlib//data//a.txt")
    .map(_.split(' ')
    .map(_.toDouble))
    .map(vue => (vue(0).toLong,vue(1).toLong,vue(2)))//转化成坐标格式
    .map(vue2 => new MatrixEntry(vue2 _1,vue2 _2,vue2 _3))//转化成坐标矩阵格式
    val crm = new CoordinateMatrix(rdd)
    println(crm.entries.foreach(println))
  }
}
