import { TestBed } from '@angular/core/testing';

import { PolicyServicesService } from './policy-services.service';

describe('PolicyServicesService', () => {
  let service: PolicyServicesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PolicyServicesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
