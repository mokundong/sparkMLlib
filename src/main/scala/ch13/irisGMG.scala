package ch13

import org.apache.spark.mllib.clustering.GaussianMixture
import org.apache.spark.mllib.clustering.KMeans
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by yousa on 2017/6/26.
  */
object irisGMG {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local").setAppName("irisGMG")
    val sc = new SparkContext(conf)

    val data = sc.textFile("E://work//SparkMLlib//data//Irisdata.txt")
    val parsedData = data.map(line => Vectors.dense(line.split(' ').map(_.toDouble))).cache()

    val model = new GaussianMixture().setK(2).run(parsedData)
    for (i <- 0 until model.k){
      println("weight=%f\num=%s\nsigma=\n%s\n" format(model.weights(i),model.gaussians(i).mu,model.gaussians(i).sigma))
    }
  }
}
