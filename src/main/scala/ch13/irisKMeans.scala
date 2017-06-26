package ch13

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisKMeans {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisKMeans")
    val sc = new SparkContext(conf)

    val data = sc.textFile("E://work//SparkMLlib//data//Irisdata.txt")
    val parsedData = data.map(line => Vectors.dense(line.split(' ').map(_.toDouble))).cache()
    val numClusters = 3//最大分类数
    val numIterations = 20//迭代次数

    val model = KMeans.train(parsedData,numClusters,numIterations)
    model.clusterCenters.foreach(println)//打印中心点坐标
  }
}
