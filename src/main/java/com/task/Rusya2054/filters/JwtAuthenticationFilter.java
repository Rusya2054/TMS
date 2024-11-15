package com.task.Rusya2054.filters;

import com.task.Rusya2054.services.JwtService;
import com.task.Rusya2054.services.UserService;
import org.springframework.web.filter.OncePerRequestFilter;

//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//    public static final String BEARER_PREFIX = "Bearer ";
//    public static final String HEADER_NAME = "Authorization";
//    private final JwtService jwtService;
//    private final UserService userService;
//
//
//    @Override
//    protected void doFilterInternal(
//            @NonNull HttpServletRequest request,
//            @NonNull HttpServletResponse response,
//            @NonNull FilterChain filterChain
//    ) throws ServletException, IOException {
//
//        // Получаем токен из заголовка
//        var authHeader = request.getHeader(HEADER_NAME);
//        if (StringUtils.isEmpty(authHeader) || !StringUtils.startsWith(authHeader, BEARER_PREFIX)) {
//            filterChain.doFilter(request, response);
//            return;
//        }
//
//        // Обрезаем префикс и получаем имя пользователя из токена
//        var jwt = authHeader.substring(BEARER_PREFIX.length());
//        var username = jwtService.extractUserName(jwt);
//
//        if (StringUtils.isNotEmpty(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = userService
//                    .userDetailsService()
//                    .loadUserByUsername(username);
//
//            // Если токен валиден, то аутентифицируем пользователя
//            if (jwtService.isTokenValid(jwt, userDetails)) {
//                SecurityContext context = SecurityContextHolder.createEmptyContext();
//
//                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//                        userDetails,
//                        null,
//                        userDetails.getAuthorities()
//                );
//
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                context.setAuthentication(authToken);
//                SecurityContextHolder.setContext(context);
//            }
//        }
//        filterChain.doFilter(request, response);
//    }
//}