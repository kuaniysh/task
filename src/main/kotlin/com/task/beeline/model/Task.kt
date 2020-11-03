package com.task.beeline.model

import javax.persistence.*

@Entity
@Table(name = "tasks")
data class Task(
        @Id // Сообщяем ORM что это поле - Primary Key
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY) // Также говорим ему что оно - Autoincrement
        val id: Long = 0L,

        @Column(name = "project", length = 50) // Говорим как будет называться поле в БД и задаем его длину
        val project: String = "", // Объявляем неизменяемое свойство (геттер, а также поле для него будут сгенерированы автоматически) name, с пустой строкой в качестве значения по умолчанию

        @Column(name = "title", length = 100)
        val title: String,

        @Column(name = "description", length = 2048)
        val description: String? = null,

        @Column(name = "assign", length = 50)
        val assign: String = ""
)