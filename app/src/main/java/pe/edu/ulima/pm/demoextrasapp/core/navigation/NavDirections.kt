import androidx.navigation.NavType
import androidx.navigation.navArgument
import pe.edu.ulima.pm.demoextrasapp.core.navigation.NavigationGroup
import pe.edu.ulima.pm.demoextrasapp.core.navigation.NavigationRoute

object HomeDirections : NavigationGroup(
    NavigationRoute(
        "home",
        emptyList()
    )
) {
    val home = NavigationRoute(
        "${root.destination}/home",
        emptyList()
    )

    val camera = NavigationRoute(
        "${root.destination}/camera",
        emptyList()
    )
    override var default = home
}


object LibraryDirections : NavigationGroup(
    NavigationRoute(
        "library",
        emptyList()
    )
) {
    val bookList = NavigationRoute(
        "${root.destination}/book-list",
        emptyList()
    )
    val bookDetail = NavigationRoute(
        "${root.destination}/book-detail",
        listOf(navArgument("bookId") { type = NavType.IntType })
    )
    val bookCommentaries = NavigationRoute(
        "${root.destination}/book-commentaries",
        listOf(navArgument("bookId") { type = NavType.IntType })
    )

    val bookReserve = NavigationRoute(
        "${root.destination}/book-reserve",
        emptyList()
    )

    override var default = bookList
}