package com.example.zgraphql.graphql
import org.springframework.stereotype.Component

// Example:
// http://localhost:8080/graphiql?path=/graphql

@Component
class HellogQueryResolver() : com.example.zgraphql.graphql.api.HellogQueryResolver
     {

       override  fun hellog() : String {
             return "zac Works now"
         }

}

/*
$session = New-Object Microsoft.PowerShell.Commands.WebRequestSession
$session.UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36"
Invoke-WebRequest -UseBasicParsing -Uri "http://localhost:8080/graphql" `
-Method "POST" `
-WebSession $session `
-Headers @{
"Accept-Encoding"="gzip, deflate, br"
  "Accept-Language"="en-US,en;q=0.9"
  "Origin"="http://localhost:8080"
  "Referer"="http://localhost:8080/graphiql?path=/graphql"
  "Sec-Fetch-Dest"="empty"
  "Sec-Fetch-Mode"="cors"
  "Sec-Fetch-Site"="same-origin"
  "accept"="application/json, multipart/mixed"
  "sec-ch-ua"="`"Not?A_Brand`";v=`"8`", `"Chromium`";v=`"108`", `"Google Chrome`";v=`"108`""
  "sec-ch-ua-mobile"="?0"
  "sec-ch-ua-platform"="`"Windows`""
} `
-ContentType "application/json" `
-Body "{`"query`":`"{ hellog }`"}"



curl 'http://localhost:8080/graphql' \
  -H 'Accept-Language: en-US,en;q=0.9' \
  -H 'Connection: keep-alive' \
  -H 'Origin: http://localhost:8080' \
  -H 'Referer: http://localhost:8080/graphiql?path=/graphql' \
  -H 'Sec-Fetch-Dest: empty' \
  -H 'Sec-Fetch-Mode: cors' \
  -H 'Sec-Fetch-Site: same-origin' \
  -H 'User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36' \
  -H 'accept: application/json, multipart/mixed' \
  -H 'content-type: application/json' \
  -H 'sec-ch-ua: "Not?A_Brand";v="8", "Chromium";v="108", "Google Chrome";v="108"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "Windows"' \
  --data-raw '{"query":"{ hellog }"}' \
  --compressed
 */