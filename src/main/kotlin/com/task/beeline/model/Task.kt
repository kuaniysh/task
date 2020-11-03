package com.task.beeline.model

import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
        @Id // Сообщяем ORM что это поле - Primary Key
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Также говорим ему что оно - Autoincrement
        val id: Long = 0L,

        @Column(name = "project", length = 100) // Говорим как будет называться поле в БД и задаем его длину
        val project: String = "", // Объявляем неизменяемое свойство (геттер, а также поле для него будут сгенерированы автоматически) name, с пустой строкой в качестве значения по умолчанию

        @Column(name = "summary", length = 500)
        val summary: String = "",

        @Column(name = "description", length = 10000)
        val description: String = "",

        @Column(name = "assign", length = 100)
        val assign: String = ""
)