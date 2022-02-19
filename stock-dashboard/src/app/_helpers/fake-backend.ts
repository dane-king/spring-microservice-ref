import { Injectable } from '@angular/core';
import { HttpRequest, HttpResponse, HttpHandler, HttpEvent, HttpInterceptor, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { delay, materialize, dematerialize } from 'rxjs/operators';
import SampleJson from '../_helpers/fake-backend.json';


@Injectable()
export class FakeBackendInterceptor implements HttpInterceptor {
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const { url, method, headers, body } = request;

    return handleRoute();

    function handleRoute() {
      switch (true) {
        case url.endsWith('/stock-quote/quotes') && method === 'GET':
          return getQuotes();
        default:
          // pass through any requests not handled above
          return next.handle(request);
      }
    }


    function getQuotes() {
      return ok(SampleJson);
    }


    // helper functions

    function ok(body?:any) {
      return of(new HttpResponse({ status: 200, body }))
        .pipe(delay(500)); // delay observable to simulate server api call
    }

    function error(message) {
      return throwError(() => new Error(message))
        .pipe(materialize(), delay(500), dematerialize()); // call materialize and dematerialize to ensure delay even if an error is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648);
    }

  }
}

export const fakeBackendProvider = {
  // use fake backend in place of Http service for backend-less development
  provide: HTTP_INTERCEPTORS,
  useClass: FakeBackendInterceptor,
  multi: true
};
