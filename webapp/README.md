Before anything, create the following directory
```bash
mkdir dist
```

By calling `build:run` it will build the static web app and start http-server on port 8080
```
	localhost:8080
```

Lifecycle scripts included in ranking-webapp:
  test
    nothing to run

### Commands
Available via `npm run-script`:

  build:js  
    browserify -t [ babelify --presets [ react ] ] assets/scripts/components.js -o dist/app.js  
  build:html  
    cp assets/html/index.html dist/index.html  
  build  
    npm run build:js & npm run build:html  
  start-http  
    node node_modules/http-server/bin/http-server dist  
  build:run  
    npm run build & npm run start-http  
