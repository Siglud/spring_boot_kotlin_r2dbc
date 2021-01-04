package org.acgeek.jerk.logic

import org.acgeek.jerk.database.CommonLogDo
import org.acgeek.jerk.repository.CommLogRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class QueryAndPiece(private val cmRep: CommLogRepository) {
    companion object {
        private val logger = LoggerFactory.getLogger(QueryAndPiece::class.java)
    }

    suspend fun getMaxFormTwo(id1: Long, id2: Long): CommonLogDo? {
        val startTime = System.currentTimeMillis()
        logger.info("开始工作！%s".format(startTime))
        val res = suspend { cmRep.findById(id1) }
        logger.info("呼叫第一个！%s".format(System.currentTimeMillis() - startTime))
        val res2 = suspend { cmRep.findById(id2) }
        logger.info("呼叫第二个！%s".format(System.currentTimeMillis() - startTime))
        res.invoke()?.let {
            it.playInstanceId.compareTo(res2.invoke()?.playInstanceId ?: -1).let { foo ->
                logger.info("比较完成！%s".format(System.currentTimeMillis() - startTime))
                return if (foo > 0) {
                    it
                } else {
                    null
                }
            }
        }
        logger.info("比较完成！%s".format(System.currentTimeMillis() - startTime))
        return null
    }
}