import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchpolicyComponent } from './searchpolicy.component';

describe('SearchpolicyComponent', () => {
  let component: SearchpolicyComponent;
  let fixture: ComponentFixture<SearchpolicyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SearchpolicyComponent]
    });
    fixture = TestBed.createComponent(SearchpolicyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
