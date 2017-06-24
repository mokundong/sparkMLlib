package ch04
import org.apache.spark.mllib.linalg.{Vector, Vectors}
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark._

/**
  * Created by MKD on 2017/4/15.
  */
object labeledPointTest2 {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("labeledPointTest2")//建立本地环境
    val sc = new SparkContext(conf)//建立spark处理
    val mu = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//wc.txt")
    mu.foreach(println)
  }
}
