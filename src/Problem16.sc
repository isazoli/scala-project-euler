object Problem16 {
	BigInt(2).pow(1000).toString.aggregate(0L)((count, z) => count + z.asDigit, (x,y) => x)
                                                  //> res0: Long = 1366
}