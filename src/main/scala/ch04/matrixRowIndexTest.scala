package ch04

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.{IndexedRowMatrix, RowMatrix,IndexedRow}

/**
  * Created by MKD on 2017/4/16.
  */
object matrixRowIndexTest {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("matrixRowTest")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d://work//Spark MLlib//data//a.txt")
      .map(_.split(' ')
        .map(_.toDouble))
      .map(line => Vectors.dense(line))
      .map((vd) => new IndexedRow(vd.size,vd))
    val rm = new IndexedRowMatrix(rdd)
    println(rm.getClass)
    println(rm.rows.foreach(println))
  }
}
