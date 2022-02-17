import com.example.ioasysbooks.domain.usecase.LoginUseCase
import org.koin.dsl.module


val domainModule = module {

    factory { LoginUseCase(get()) }
}