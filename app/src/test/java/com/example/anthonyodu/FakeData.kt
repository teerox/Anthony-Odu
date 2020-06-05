package com.example.anthonyodu

import com.example.anthonyodu.model.CarOwner
import com.example.anthonyodu.model.Filter


object FakeData {

    private val car1 = CarOwner(
        1, "Tony", "Scot",  "shainning0@so-net.ne.jp",
        "Thailand", "Lincoln",
        "2007", "Maroon", "Male",
        "Staff Accountant III", "Cras mi pede" +
                "malesuada in, imperdiet et, commodo vulputate, justo. In blandit ultrices enim. Lorem ipsum dolor sit amet, " +
                "consectetuer adipiscing elit. Proin interdum mauris non ligula pellentesque ultrices."
    )

    private val car2 = CarOwner(
        2, "Vannie", "Fitzer",
        "vfitzer1@samsung.com", "France", "Chrysler", "2005", "Aquamarine",
        "Female", "VP Quality Control",
        "Nulla facilisi. Cras non velit nec nisi vulputate nonummy. Maecenas tincidunt lacus at" +
                " velit. Vivamus vel nulla eget eros elementum pellentesque."
    )

    private val car3 = CarOwner(
        3,
        "Sissy",
        "Willbourne",
        "swillbourne2@xinhuanet.com",
        "Bolivia",
        "Lexus",
        "2004",
        "Puce",
        "Female",
        "Staff Accountant",
        "I	Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, " +
                "condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. " +
                "Cras pellentesque volutpat dui."
    )

    private val car4 = CarOwner(
        4,
        "Sissy",
        "Willbourne",
        "swillbourne2@xinhuanet.com",
        "China",
        "Volkswagen",
        "1996",
        "Turquoise",
        "Female",
        "Tax Accountant",
        "Morbi non quam nec dui luctus rutrum. Nulla tellus. In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus. Suspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst. Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem."
    )

    private val car5 = CarOwner(
        5,
        "Fedric",
        "Willbou",
        "swillbourne2@xinhuet.com",
        "United States",
        "Lincoln",
        "1995",
        "Blue",
        "Male",
        "SPharmacist",
        "I	Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, " +
                "condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. " +
                "Cras pellentesque volutpat dui."
    )
    private val car6 = CarOwner(
        6,
        "Sissy",
        "Willbourne",
        "swillbourne2@xinhuanet.com",
        "Bolivia",
        "Lexus",
        "2004",
        "Orange",
        "Female",
        "Staff Accountant",
        "I	Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, " +
                "condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. " +
                "Cras pellentesque volutpat dui."
    )
    private val car7 = CarOwner(
        7,
        "Corbin",
        "Fiske",
        "swillbourne2@xinhuanet.com",
        "Paraguay",
        "Ford",
        "2010",
        "Purple",
        "Male",
        "Analyst Programmer",
        "I	Maecenas rhoncus aliquam lacus. Morbi quis tortor id nulla ultrices aliquet. Maecenas leo odio, " +
                "condimentum id, luctus nec, molestie sed, justo. Pellentesque viverra pede ac diam. " +
                "Cras pellentesque volutpat dui."
    )
    private val car8 = CarOwner(
        8,
        "Sissy",
        "Willbourne",
        "swillbourne2@xinhuanet.com",
        "China",
        "Lexus",
        "2006",
        "Red",
        "Female",
        "Assistant Media Planner",
        "Etiam faucibus cursus urna. Ut tellus. Nulla ut erat id mauris vulputate elementum. Nullam varius."
    )


    val arrayCarOwner = arrayListOf(car1, car2, car3, car4, car5, car6, car7, car8)



    private val filter1 = Filter(
        arrayListOf("Green", "Violet", "Yellow", "Blue","Maroon"),
        arrayListOf("Brazil", "Ireland", "Egypt", "Peru","Thailand"),
        2009,
        "male",
        1,2007)

    private val filter2 = Filter(
        arrayListOf("Teal", "Maroon", "Red", "Orange"),
        arrayListOf("Russia", "Portugal", "Vietnam", "Croatia", "Uganda", "Iran"),
        2010,
        "",
        2,1990)

    private val filter3 = Filter(
        arrayListOf("Red", "Aquamarine", "Orange", "Mauv"),
        arrayListOf(),
        2009,
        "",
        3,2001)



    val arrayFilter = arrayListOf(filter1, filter2, filter3)
}