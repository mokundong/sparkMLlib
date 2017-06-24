package ch04

import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.linalg.distributed.{IndexedRowMatrix, RowMatrix,IndexedRow}
/**
  * Created by MKD on 2017/6/24.带有行索引的行矩阵
  */
object indexedRowMatrixText {
  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    .setMaster("local")
    .setAppName("indexedRowMatrixText")
    val sc = new SparkContext(conf)
    val rdd = sc.textFile("d://work//Spark MLlib//data//a.txt")
    .map(_.split(' ')
    .map(_.toDouble))
    .map(line => Vectors.dense(line))//转化成向量储存
    .map((vd) => new IndexedRow(vd.size,vd))//转化格式
    val irm = new IndexedRowMatrix(rdd)//建立索引行矩阵实例
    println(irm.getClass)
    println(irm.rows.foreach(println))
  }
}
