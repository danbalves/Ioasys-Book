import com.example.ioasysbooks.domain.usecase.GetBookListUseCase
import com.example.ioasysbooks.domain.usecase.GetSearchBookUseCase
import com.example.ioasysbooks.domain.usecase.LoginUseCase
import com.example.ioasysbooks.domain.usecase.SaveBookListUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module


val domainModule = module {

    single { CoroutineScope(Dispatchers.IO) }

    factory { LoginUseCase(get(), get()) }
    factory { GetBookListUseCase(get(), get()) }
    factory { SaveBookListUseCase(get(), get()) }
    factory { GetSearchBookUseCase(get(), get()) }
}