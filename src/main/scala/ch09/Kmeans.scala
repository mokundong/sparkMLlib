package ch09

import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.util.MLUtils
import org.apache.spark.{SparkConf,SparkContext}

/**
  * Created by MKD on 2017/6/25.

object Kmeans {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("Kmeans")
    val sc = new SparkContext(conf)
    val data = MLUtils.loadLibSVMFile(sc,"d://work//Spark MLlib//data//Kmeans.txt")
    val parsedData = data.map(s=>Vectors.dense(s.split(' ').map(_.toDouble))).cache()
    val numClusters = 2
    val numIterations = 20
    val model = KMeans.train(parsedData,numClusters,numIterations)
    model.clusterCenters.foreach(println)
  }
}
  */