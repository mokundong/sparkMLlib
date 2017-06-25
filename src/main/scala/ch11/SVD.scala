package ch11

import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.RowMatrix
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by MKD on 2017/6/25.
  */
object SVD {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("SVD")
    val sc = new SparkContext(conf)

    val data = sc.textFile("d://work//Spark MLlib//data//svd.txt")
    .map(_.split(' ')
    .map(_.toDouble))
    .map(line => Vectors.dense(line))

    val rm = new RowMatrix(data)
    val SVD = rm.computeSVD(2,computeU = true)
    println(SVD)
  }

}
