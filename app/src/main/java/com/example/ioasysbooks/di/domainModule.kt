import com.example.ioasysbooks.domain.usecase.GetBookListUseCase
import com.example.ioasysbooks.domain.usecase.LoginUseCase
import com.example.ioasysbooks.domain.usecase.SaveBookListUseCase
import org.koin.dsl.module


val domainModule = module {

    factory { LoginUseCase(get()) }
    factory { GetBookListUseCase(get()) }
    factory { SaveBookListUseCase(get()) }
}