package ms.com.uce.application.service.interceptors;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@MedirTiempo
@Interceptor
public class MedirTiempoInterceptor {
    @AroundInvoke
    public Object tiempo(InvocationContext context) throws Exception {
        System.out.println("(Interceptor) Metetodo interceptado: " + context.getMethod().getName());
        long inicio = System.currentTimeMillis();
        Object resultado = context.proceed();
        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;
        System.out.println("(Interceptor) Tiempo transcurrido para " + context.getMethod().getName() + ": " + duracion + "ms" + "\n");
        return resultado;
    }
}