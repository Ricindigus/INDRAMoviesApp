package pe.com.dmorales.moviesapp.core.domain.exceptions

class ConnectException(message: String = "No hay conexión a internet") : Exception(message)
class UnknownHostException(message: String = "Host desconocido") : Exception(message)
class RequestResouseForbiddenException(message: String = "") : Exception(message)
class SocketTimeoutException(message: String = "No hay respuesta en la conexión") : Exception(message)
class UnauthorizedException(message: String = "Usuario no autorizado") : Exception(message)
class PasswordInvalidException(message: String = "Contraseña incorrecta") : Exception(message)
class UserNotFoundException(message: String = "Usuario no existe") : Exception(message)
class UnExpectedException(message: String = "Excepción no esperada") : Exception(message)
class HttpException(message: String = "Error en la petición http") : Exception(message)
class NotFoundException(message: String = "Not Found"):Exception(message)