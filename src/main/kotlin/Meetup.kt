import java.time.DayOfWeek
import java.time.LocalDate

class Meetup(private val month: Int, private val year: Int) {

    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate{

        var localDate = LocalDate.of(year, month, 1)
        val meetupList = mutableListOf<LocalDate>()

        while (true) {

            if (localDate.dayOfWeek == dayOfWeek) meetupList.add(localDate)

            localDate = localDate.plusDays(1)

            if (localDate.monthValue != month) break
        }

        return when (schedule) {
            MeetupSchedule.FIRST -> meetupList[0]
            MeetupSchedule.SECOND -> meetupList[1]
            MeetupSchedule.THIRD -> meetupList[2]
            MeetupSchedule.FOURTH -> meetupList[3]
            MeetupSchedule.LAST -> meetupList.last()
            else -> meetupList.first { it.dayOfMonth in 13..19 }
        }
    }
}
